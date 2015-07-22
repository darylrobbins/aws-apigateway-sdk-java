/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.service.apigateway.importer.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.service.apigateway.importer.ApiImporterMain;
import com.amazonaws.service.apigateway.importer.RamlApiImporter;
import com.amazonaws.service.apigateway.importer.SwaggerApiImporter;
import com.amazonaws.service.apigateway.importer.impl.raml.sdk.ApiGatewaySdkRamlApiImporter;
import com.amazonaws.service.apigateway.importer.impl.swagger.sdk.ApiGatewaySdkSwaggerApiImporter;
import com.amazonaws.services.apigateway.AmazonApiGateway;
import com.amazonaws.services.apigateway.model.ApiGateway;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApiImporterModule extends AbstractModule {
    private static final Log LOG = LogFactory.getLog(ApiImporterMain.class);

    private final AwsConfig config;

    public ApiImporterModule(AwsConfig config) {
        this.config = config;
    }

    @Override
    protected void configure() {
        bind(SwaggerApiImporter.class).to(ApiGatewaySdkSwaggerApiImporter.class);
        bind(RamlApiImporter.class).to(ApiGatewaySdkRamlApiImporter.class);
        bind(String.class).annotatedWith(Names.named("profile")).toInstance(config.getProfile());
        bind(String.class).annotatedWith(Names.named("region")).toInstance(config.getRegion());
    }

    @Provides
    AWSCredentialsProvider provideCredentialsProvider(@Named("profile") String profile) {
        ProfileCredentialsProvider provider = new ProfileCredentialsProvider(profile);

        try {
            provider.getCredentials();
        } catch (Throwable t) {
            LOG.error("Could not load AWS configuration. Please run 'aws configure'");
            throw t;
        }

        return provider;
    }

    @Provides
    ApiGateway provideAmazonApiGateway(AWSCredentialsProvider credsProvider,
                                       @Named("region") String region) {
        return new AmazonApiGateway(getEndpoint(region)).with(credsProvider).getApiGateway();
    }

    private String getEndpoint(String region) {
        return String.format("https://apigateway.%s.amazonaws.com", region);
    }
}