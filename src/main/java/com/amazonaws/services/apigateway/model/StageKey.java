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

package com.amazonaws.services.apigateway.model;

public class StageKey {

    private String restApiId;

    private String stageName;



    /**
     * Returns the value of the restApiId property for this object.
     *
     * @return The value of the restApiId property for this object.
     */
    public String getRestApiId() {
        return restApiId;
    }

    /**
     * Sets the value of the restApiId property for this object.
     *
     * @param restApiId The new value for the restApiId property for this object.
     */
    public void setRestApiId(String restApiId) {
        this.restApiId = restApiId;
    }

    /**
     * Sets the value of the restApiId property for this object.
     *
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param restApiId The new value for the restApiId property for this object.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StageKey withRestApiId(String restApiId) {
        this.restApiId = restApiId;
        return this;
    }


    /**
     * Returns the value of the stageName property for this object.
     *
     * @return The value of the stageName property for this object.
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * Sets the value of the stageName property for this object.
     *
     * @param stageName The new value for the stageName property for this object.
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * Sets the value of the stageName property for this object.
     *
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param stageName The new value for the stageName property for this object.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StageKey withStageName(String stageName) {
        this.stageName = stageName;
        return this;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRestApiId() != null) sb.append("restApiId: " + getRestApiId() + ",");
        if (getStageName() != null) sb.append("stageName: " + getStageName() + ",");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + ((getRestApiId() == null) ? 0 : getRestApiId().hashCode());
        hashCode = prime * hashCode + ((getStageName() == null) ? 0 : getStageName().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof StageKey == false) return false;
        StageKey other = (StageKey)obj;

        if (other.getRestApiId() == null ^ this.getRestApiId() == null) return false;
        if (other.getRestApiId() != null && other.getRestApiId().equals(this.getRestApiId()) == false) return false;
        if (other.getStageName() == null ^ this.getStageName() == null) return false;
        if (other.getStageName() != null && other.getStageName().equals(this.getStageName()) == false) return false;
        return true;
    }

}
