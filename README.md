# web-pageobject-junit
Sample project for web automated testing

```
>geckodriver.exe --version
geckodriver 0.24.0 ( 2019-01-28)

The source code of this program is available from
testing/geckodriver in https://hg.mozilla.org/mozilla-central.

This program is subject to the terms of the Mozilla Public License 2.0.
You can obtain a copy of the license at https://mozilla.org/MPL/2.0/.)

Firefox: Version 68.0.2 (64-bit)
```

Tùy chỉnh cấu hình FirefoxDriver với `serenity.properties`

```
# Define the default driver
webdriver.gecko.driver=.\\drivers\\geckodriver.exe
webdriver.base.url = https://www.amabuy.vn/

serenity.extension.packages=vn.amabuy.capabilities.firefox
```


