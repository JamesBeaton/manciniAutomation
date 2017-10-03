var assert = require('assert');

describe('facebook page', function(){
    it('should have the right title', function(){
        browser.url('/');
        browser.windowHandleSize({width:1280,height:800});
        var title = browser.getTitle();
        assert.equal(title, 'Facebook – log in or sign up');
     })

    it('should have the right link', function(){
    	browser.url('/');
        var hasText = browser.isExisting ('=Log In')
        assert(hasText);
    })  

    it('should input username', function(){
	    browser.url('/');
	    browser.setValue('input[type="email"]', 'gamesysbronze@gmail.com');
	    browser.setValue('input[type="password"]', 'GsysAuto1');
		browser.click('#loginbutton');	
		
	})  

	it('should load jpj lobby', function(){
		browser.url('/slotsofun-devthree');
		browser.pause(15000);
	})

	it('should open coin store', function(){
	    var vip = $('#root > div > div.Application__Container > div.ApplicationLayout__ContentContainer > div > div.ApplicationLayout__StatusBar > div > div > div.StatusBar__LeftPart > div:nth-child(2) > div > span');
	    vip.waitForExist(50000);
	    vip.click();

	})  

});
