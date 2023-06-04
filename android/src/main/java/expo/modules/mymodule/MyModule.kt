package expo.modules.mymodule

import android.net.Uri
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import java.io.Serializable

class MyModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('MyModule')` in JavaScript.
    Name("MyModule")

    // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
    Function("hello") {
      "Hello shubham! 👋"
    }

    AsyncFunction("pickPhoto") {
        pickMediaRequest.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
    }

      RegisterActivityContracts {
          pickMediaRequest = registerForActivityResult(PickVisualMedia())  { uri ->
              // Callback is invoked after the user selects a media item or closes the
              // photo picker.
              if (uri != null) {
                  Log.d("PhotoPicker", "Selected URI: $uri")
              } else {
                  Log.d("PhotoPicker", "No media selected")
              }
          }
      }
    }




  private val context
    get() = requireNotNull(appContext.reactContext) {
      "React context is not available. Make sure that you've initialized the module properly."
    }


    private lateinit var pickMediaRequest: ActivityResultLauncher<PickVisualMediaRequest>

}




