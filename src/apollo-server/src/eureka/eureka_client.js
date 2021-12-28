import Eureka from 'eureka-js-client';

// Or, if you're not using a transpiler:
const Eureka = require('eureka-js-client').Eureka;

// example configuration
const client = new Eureka({
    // application instance information
    instance: {
        app: 'apollo-server',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: 4000,
        vipAddress: 'jq.test.something.com',
        dataCenterInfo: {
            name: 'MyOwn',
        },
    },
    eureka: {
        // eureka server host / port
        host: '127.0.0.1',
        port: 8761,
    },
});

module.exports = client;