package ti.andinstreferrer;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import ti.andinstreferrer.TiAndroidInstallReferrerModule;

public class ReferrerBroadcastReceiver extends BroadcastReceiver {
	private static final String LCAT = "TiAndroidInstallReferrerModule";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String referrer = intent.getStringExtra("referrer");
		Log.d(LCAT, "referrer: " + referrer);

		SharedPreferences sharedPref = context.getSharedPreferences("tiandinstreferrer", 0);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString("referrer", referrer);
		editor.commit();
		
		/* Otherwise, just resume the app if necessary, and trigger the event */
        try {
        	KrollDict data = new KrollDict();
        	data.put("referrer", referrer);

            TiAndroidInstallReferrerModule.getInstance().fireEvent("onReceive", data);
        } catch (Exception e) {
            Log.d(LCAT, "onReceive: " + e.getMessage());
        }
	}
}