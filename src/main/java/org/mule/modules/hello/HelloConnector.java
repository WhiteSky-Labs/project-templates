/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.hello;

import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.ConnectionException;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Processor;

import org.mule.api.annotations.param.Default;

/**
 * Anypoint Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="hello", schemaVersion="1.0", friendlyName="Hello")
public class HelloConnector
{
    /**
     * Configurable
     */
    @Configurable
    @Default("value")
    private String myProperty;

    

    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey String username, @Password String password)
        throws ConnectionException {
        /*
         * CODE FOR ESTABLISHING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        /*
         * CODE FOR CLOSING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        //TODO: Change it to reflect that we are connected.
        return false;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }
    /**
     * Custom processor
     *
     * {@sample.xml ../../../doc/hello-connector.xml.sample hello:my-processor}
     *
     * @param content Content to be processed
     * @return Some string
     */
    @Processor
    public String myProcessor(String content) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return content;
    }

    /**
     * Set property
     *
     * @param myProperty My property
     */
    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    /**
     * Get property
     */
    public String getMyProperty() {
        return this.myProperty;
    }
}