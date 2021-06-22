![alt text](https://drive.google.com/uc?id=142Tvn8Elm6oECxlrxuk1JP8xIbELrow_)

# Night Mode Button

### Night Mode Button Library for Android

Easy to use night mode button with cool day night animation.

  ### Version
[![](https://jitpack.io/v/Kaustuv-Mahanti/NightOwl.svg)](https://jitpack.io/#Kaustuv-Mahanti/NightOwl)

### Installation

* **Gradle**

	Add it in your root build.gradle at the end of repositories:
	```gradle
  allprojects {
  		repositories {
  			...
  			maven { url 'https://jitpack.io' }
  		}
  	}
	```

	Add the dependency in your app build.gradle
	```gradle
  dependencies {
  	        implementation 'com.github.Kaustuv-Mahanti:NightOwl:v1.5.0'
  	}
	```

* **Maven**

	Add the JitPack repository to your build file
	```gradle
	<repositories>
    		<repository>
    		    <id>jitpack.io</id>
    		    <url>https://jitpack.io</url>
    		</repository>
    	</repositories>
	```

	Add the dependency
	```gradle
  	<dependency>
    	    <groupId>com.github.Kaustuv-Mahanti</groupId>
    	    <artifactId>NightOwl</artifactId>
    	    <version>v1.5.0</version>
    	</dependency>
	```
  
### Usage

Drop the Night Mode Button in your XML layout as is shown below:
```xml
    	<com.nightowl.library.NightOwlToggleButton
        		android:layout_width="wrap_content"
        		android:layout_height="wrap_content"
        		android:layout_centerHorizontal="true"
        		android:id="@+id/nightModeButton"
        		android:layout_centerVertical="true"/>

```
And Use in Java:
```java
        
         NightModeButton nightModeButton;

         nightModeButton = findViewById(R.id.nightModeButton);

        nightModeButton.setOnSwitchListener(new NightModeButton.OnSwitchListener() {
            @Override
            public void onSwitchListener(boolean isNight) {
                if(isNight){
                    Toast.makeText(getApplicationContext(),"Night Mode On",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Night Mode Off",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Toggle nightModeButton programmatically

        //Toggle ON:
        nightModeButton.setToggle(true);
        //Toggle OFF:
        nightModeButton.setToggle(false);
        

        
```

## License

```
MIT License

Copyright (c) 2021 Kaustuv Mahanti

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
