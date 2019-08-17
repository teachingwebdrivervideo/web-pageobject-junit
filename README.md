# web-pageobject-junit
Sample project for web automated testing

## Kiểm tra mức độ tương thích (compatibility) 

Tránh những lỗi do không tương thích phiên bản cần kiểm tra giữa trình duyệt (browser) và trình điều khiển (webdriver)

### Đối với webdriver
Di chuyển vào thư mục chứa webdriver là _web-pageobject-junit\drivers_ sau đó gõ lệnh: `chromedriver.exe --version`

```
ChromeDriver 75.0.3770.140 (2d9f97485c7b07dc18a74666574f19176731995c-refs/branch-heads/3770@{#1155})
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
# Chrome arguments
chrome.switches=start-maximized;--incognito;

# Chrome capabilities
chrome.capabilities.unexpectedAlertBehaviour=ignore
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
