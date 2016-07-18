# Receiving Google Play Store's referrer parameter

## Description

Titanium android native module for receiving Google Play Store's referrer parameter

## Accessing the ti.andinstreferrer Module

To access this module from JavaScript, you would do the following:

    var andinstreferrer = require('ti.andinstreferrer');

The andinstreferrer variable is a reference to the Module object.

## Method
	1. getReferrer();

## Event
	1. onReceive

## Usage
It's work on everywhere.

    if (OS_ANDROID) {
        var andinstreferrer = require('ti.andinstreferrer');
        var referrer = andinstreferrer.getReferrer();
        Ti.API.debug("andinstreferrer", "getReferrer", referrer);

        andinstreferrer.addEventListener('onReceive', function(e) {
            Ti.API.debug("andinstreferrer", "onReceive", e.referrer);
        });
    }
    
## Test
Need to use ADB.

    adb shell am broadcast -a com.android.vending.INSTALL_REFERRER --es "referrer" "test message"
    
## Reference

Thanks for :

    https://developers.google.com/android/reference/com/google/android/gms/analytics/CampaignTrackingReceiver
    http://www.oodlestechnologies.com/blogs/Tracking-Install-Referrer-or-Campaign-Referrer-for-Android-App-in-Titanium
    https://github.com/Px-Factor/titanium-installreferrer

## Author

Dongwoo Gim, BOXOUT THINKERS

## License

MIT License
