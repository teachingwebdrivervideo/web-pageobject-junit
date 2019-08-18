# web-pageobject-junit
Customize Chrome Driver

## Kiểm tra mức độ tương thích (compatibility) 

Tránh những lỗi do không tương thích phiên bản cần kiểm tra giữa trình duyệt (browser) và trình điều khiển (webdriver)

### Đối với webdriver
Di chuyển vào thư mục chứa webdriver là _web-pageobject-junit\drivers_ sau đó gõ lệnh: `chromedriver.exe --version`

```
ChromeDriver 76.0.3809.68 (420c9498db8ce8fcd190a954d51297672c1515d5-refs/branch-heads/3809@{#864})
```

### Đối với browser

Click vào hambuger button góc trên bên phải. Chọn vào _Help/About Google Chrome_
```
Google Chrome is up to date
Version 76.0.3809.100 (Official Build) (64-bit)
```

### Tùy chỉnh cấu hình ChromeDriver
Mở file _serenity.properties_ và kiểm tra các thông tin sau.

```
webdriver.driver = provided
webdriver.provided.type = mydriver
webdriver.provided.mydriver = vn.amabuy.customedriver.ChromeCustomeDriver
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
