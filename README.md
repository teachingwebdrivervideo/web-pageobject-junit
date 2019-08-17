# web-pageobject-junit
Sample project for web automated testing

Trong một repository có thể có một hay nhiều nhánh (branch) khác nhau.

Khi tạo một repository mới hệ thống sẽ tự tạo cho bạn một nhánh mặc định có tên là **master**

Trong trường hợp bạn có nhiều cấu hình khác nhau và để tránh xung đột thì việc tạo các nhánh phụ là cần thiết.

Để tạo nhánh phụ bạn gõ lệnh

git checkout -b [tên nhánh]

E.g: `git checkout -b configuration/firefox/customizedriver`

Để kiểm tra bạn đang đứng ở branh nào gõ lệnh: `git branch` hệ thống sẽ liệt kê toàn bộ số branch hiện có. Dấu * là thể hiện bạn đang làm việc trên nhánh đó
```
  configuration/chrome/options/conf
  configuration/chrome/options/extendingpackage
* configuration/firefox/customizedriver
  master
```

Để chuyển qua (switch) giữa cách branch gõ lệnh : git checkout [tên nhánh]

E.g `git checkout configuration/chrome/options/conf` lúc này gõ lại lệnh `git branch` bạn sẽ thấy nhánh đã được chuyển. 

**Lưu ý lệnh này rất giống với lệnh tạo mới branch chỉ khác là không có tham số -b**
```
* configuration/chrome/options/conf
  configuration/chrome/options/extendingpackage
  configuration/firefox/customizedriver
  master
```

Để đẩy code lên đúng nhánh đang làm việc gõ lệnh dưới đây. Lưu ý trước khi push cần phải gõ lệnh `add` và `commit`
```
git push --set-upstream origin configuration/firefox/customizedriver
```

Mọi thứ sẽ dễ dàng hơn nếu bạn học cách dùng git client desktop. Tải và cài đặt theo link dưới đây
- https://www.sourcetreeapp.com/  ([Video tutorial](https://www.youtube.com/watch?v=FIabco-p_nY))
- https://desktop.github.com/

## Chỉnh sửa cấu hình cho WebDriver
### Firefox
Code mẫu trong branch [configuration/firefox/customizedriver](https://github.com/teachingwebdrivervideo/web-pageobject-junit/tree/configuration/firefox/customizedriver) cho [Bài #30](https://github.com/Jacobvu84/serenity-pageobject-junit-webdriver/issues/30): Chỉnh sửa cấu hình của WebDriver 
