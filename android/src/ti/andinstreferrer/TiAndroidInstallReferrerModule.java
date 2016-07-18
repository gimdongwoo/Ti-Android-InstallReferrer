package ti.andinstreferrer;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.content.SharedPreferences;

@Kroll.module(name="TiAndroidInstallReferrer", id="ti.andinstreferrer")
public class TiAndroidInstallReferrerModule extends KrollModule
{
	// Module instance
    private static TiAndroidInstallReferrerModule module;

	// Standard Debugging variables
	private static final String LCAT = "TiAndroidInstallReferrerModule";
	private static final boolean DBG = TiConfig.LOGD;
	static SharedPreferences sharedPref;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;

	public TiAndroidInstallReferrerModule()
	{
		super();
		module = this;
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(LCAT, "inside onAppCreate");
		// put module init code that needs to run when the application is created
		
		sharedPref = app.getSharedPreferences("tiandinstreferrer", 0);
	}
	
	/* Get an instance of that module*/
    public static TiAndroidInstallReferrerModule getInstance() {
        return module;
    }

	// Methods
	@Kroll.method
	public String getReferrer()
	{
		Log.d(LCAT, "example called");
		String referralUrl = sharedPref.getString("referrer", null);
		
		if (referralUrl != null && !referralUrl.equals("")) {
			return referralUrl;
		}
		
		return null;
	}

//	// Properties
//	@Kroll.getProperty
//	public String getExampleProp()
//	{
//		Log.d(LCAT, "get example property");
//		return "hello world";
//	}
//
//
//	@Kroll.setProperty
//	public void setExampleProp(String value) {
//		Log.d(LCAT, "set example property: " + value);
//	}

}
