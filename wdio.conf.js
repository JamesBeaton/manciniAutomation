exports.config = {

    /**
     * server configurations
     */
    host: '0.0.0.0',
    port: 4444,

    /**
     * specify test files
     */
    specs: [
        './test/**/*.js'
    ],
    exclude: [
        
    ],

    /**
     * capabilities
     */
    capabilities: [{
    
        maxInstances: 5,

        browserName: 'chrome'
    
    }],

    /**
     * test configurations
     */
    logLevel: 'silent',
    coloredLogs: true,
    screenshotPath: './errorShots/',
    baseUrl: 'https://apps.facebook.com',
    waitforTimeout: 10000,
    framework: 'jasmine',

    reporters: ['dot'],
    reporterOptions: {
        outputDir: './'
    },

    jasmineNodeOpts: {
        defaultTimeoutInterval: 9999999,

        expectationResultHandler: function(passed, assertion) {
            // do something
        }
    },

    /**
     * hooks
     */
    onPrepare: function() {
        console.log('let\'s go');
    },
    onComplete: function() {
        console.log('that\'s it');
    }

};