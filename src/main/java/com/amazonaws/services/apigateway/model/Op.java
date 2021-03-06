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

/**
 * Op
 */
public enum Op {

    Add("add"),
    Remove("remove"),
    Replace("replace"),
    Move("move"),
    Copy("copy"),
    Test("test");

    private String value;

    private Op(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
    * Use this in place of valueOf.
    *
    * @param value real value
    * @return Op corresponding to the value
    */
    public static Op fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("add".equals(value)) {
            return Op.Add;
        } else if ("remove".equals(value)) {
            return Op.Remove;
        } else if ("replace".equals(value)) {
            return Op.Replace;
        } else if ("move".equals(value)) {
            return Op.Move;
        } else if ("copy".equals(value)) {
            return Op.Copy;
        } else if ("test".equals(value)) {
            return Op.Test;
        } else {
            throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
        }
    }
}