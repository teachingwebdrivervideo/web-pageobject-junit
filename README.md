# web-pageobject-junit
Sample project for web automated testing

## Kiểm tra mức độ tương thích (compatibility) 

Tránh những lỗi do không tương thích phiên bản cần kiểm tra giữa trình duyệt (browser) và trình điều khiển (webdriver)

### Đối với webdriver
Di chuyển vào thư mục chứa webdriver là _web-pageobject-junit\drivers_ sau đó gõ lệnh: `geckodriver.exe --version`

```
geckodriver 0.24.0 ( 2019-01-28)

The source code of this program is available from
testing/geckodriver in https://hg.mozilla.org/mozilla-central.

This program is subject to the terms of the Mozilla Public License 2.0.
You can obtain a copy of the license at https://mozilla.org/MPL/2.0/.)
```

### Đối với browser

Click vào hambuger button góc trên bên phải. Chọn vào _Help/About Firefox_
```
Firefox: Version 68.0.2 (64-bit)
```

### Tùy chỉnh cấu hình FirefoxDriver
Mở file _serenity.properties_ và kiểm tra các thông tin sau.

Chú ý: _webdriver.driver_ sẽ không còn đặt giá trị tên của trình duyệt là **chrome** hay **firefox** nữa mà phải đổi thành **provided**

```
# Define the default driver
webdriver.gecko.driver=.\\drivers\\geckodriver.exe
webdriver.base.url = https://www.amabuy.vn/

webdriver.driver = provided
webdriver.provided.type = mydriver
webdriver.provided.mydriver = vn.amabuy.customedriver.FireFoxCustomeDriver
thucydides.driver.capabilities = mydriver
```
### Lệnh chạy kịch bản test

1. Chạy theo tag. Khi chạy theo tag tên file **PHẢI** đặt đúng với convention trong phần _configuration_ của _maven-failsafe-plugin_

```
mvn clean verify -Dtags="alert"
```

2. Chạy theo tên file. Tên file có thể tùy biến, trong trường hợp này không cần theo convention nhưng không nên để tránh những lỗi không đáng có

```
mvn clean verify -Dit.test=WhenCheckInterfaceAlertPopup
```

