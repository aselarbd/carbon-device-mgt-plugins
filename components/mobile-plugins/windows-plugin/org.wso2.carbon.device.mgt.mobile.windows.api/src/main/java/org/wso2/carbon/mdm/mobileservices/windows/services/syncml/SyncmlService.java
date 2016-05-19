/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.mdm.mobileservices.windows.services.syncml;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.w3c.dom.Document;
import org.wso2.carbon.device.mgt.common.notification.mgt.NotificationManagementException;
import org.wso2.carbon.mdm.mobileservices.windows.common.PluginConstants;
import org.wso2.carbon.mdm.mobileservices.windows.common.exceptions.WindowsConfigurationException;
import org.wso2.carbon.mdm.mobileservices.windows.common.exceptions.WindowsDeviceEnrolmentException;
import org.wso2.carbon.mdm.mobileservices.windows.operations.WindowsOperationException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Interface for Syncml message flow.
 */
@Api(value = "SyncmlService", description = "Windows Device Management REST-API implementation.")
@Path("/devicemanagement")
public interface SyncmlService {

    @Path("/request")
    @POST
    @Consumes({PluginConstants.SYNCML_MEDIA_TYPE, MediaType.APPLICATION_XML})
    @Produces(PluginConstants.SYNCML_MEDIA_TYPE)
    @ApiOperation(
            consumes = "application/vnd.syncml.dm+xml;charset=utf-8",
            produces = "application/vnd.syncml.dm+xml;charset=utf-8",
            httpMethod = "POST",
            value = "Windows Device Management service REST API",
            notes = "Windows device management session"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed syncml session"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    Response getResponse(Document request) throws WindowsDeviceEnrolmentException, WindowsOperationException,
            NotificationManagementException, WindowsConfigurationException;

}