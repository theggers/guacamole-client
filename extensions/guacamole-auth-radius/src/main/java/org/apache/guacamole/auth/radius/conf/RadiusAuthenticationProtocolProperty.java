/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.guacamole.auth.radius.conf;

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.GuacamoleServerException;
import org.apache.guacamole.properties.GuacamoleProperty;

/**
 * A GuacamoleProperty whose value is a RadiusAuthenticationProtocol.
 */
public abstract class RadiusAuthenticationProtocolProperty
        implements GuacamoleProperty<RadiusAuthenticationProtocol> {
    
    @Override
    public RadiusAuthenticationProtocol parseValue(String value)
            throws GuacamoleException {
        
        // Nothing provided, nothing returned
        if (value == null)
            return null;
        
        // Attempt to parse the string value
        RadiusAuthenticationProtocol authProtocol = 
                RadiusAuthenticationProtocol.getEnum(value);
        
        // Throw an exception if nothing matched.
        if (authProtocol == null)
            throw new GuacamoleServerException(
                    "Invalid or unsupported RADIUS authentication protocol.");
        
        // Return the answer
        return authProtocol;
        
    }
    
}
