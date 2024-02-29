## MAVEN

- modules: khai báo các sub-module và khi thực hiện lifecycle ở module thì các sub-modules cũng thực hiện theo
- sự khác nhau giữa đóng gói file jar và war:
  - jar: đóng gói tất cả bao gồm cả servlet container để chạy trên JVM độc lập
  - war: chỉ đóng gói mã nguồn còn lại servlet container phải tự config ngoài để chạy hoặc tự custom

### POM

- trong maven 1 phụ thuộc hay 1 module sẽ luôn có 1 file pom.xml
- khi muốn kế thừa phụ thuộc nào đấy thì phụ thuộc được kế thừa phải là `pakaging pom`
- về bản chất `dependencyManagement` sẽ quản lý version của phụ thuộc

##### DEPENDENCY

- là các phụ thuộc được chỉ định trong project

###### type:

- `pom`: `chỉ định` lấy file pom hay có nghĩa là ngoài dependency của `Artifact` ra thì sẽ không bao gồm jar
  của `Artifact` đó

###### scope:

-`import`: đặc biệt chỉ support cho dependency của `dependencyManagement` và nó sẽ lấy những phụ thuộc trong file pom.xml của `Artifact` đó về để quản lý dự án hiện tại
-`provided` sẽ không đóng gói thư viện vào trong file jar mà sử dụng thư viện được cấp bởi bên thứ 3 hoặc môi trường
thực thi
và ta phải chắc chắn nó đã có trong môi trường, nó được sử dụng trong quá trình `compile và package`
-`compile`: mặc định sẽ thêm vào classpath lúc compile và cho đến lúc runtime

###### exclusions:

- loại bỏ phụ thuộc con có trong phụ thuộc đó

###### optional:

- inject phụ thuộc vào cha nhưng không inject vào sub-project (dự án con)

### Vòng đơi của build

#### Default lifecycle

- `Validate`: xác nhận tất cả các thông tin của dự án là hợp lệ và chính xác
- `Compile`: biên dịch source
- `Test`: chạy unit test
- `Package`: đóng gói code đã được biên dịch thành file jar hoặc war được định nghĩa trong file pom
- `Verify`: thực hiện kiểm tra việc đóng gói đã chính xác hay chưa.
- `Install`: cài đặt các gói trong local repositories -> đưa dự án đã build vào local repositories
- `Deploy`: đưa dự án đã build vào remote repositories bằng file jar hoặc war đã được đóng gói

  	Khi thực hiện một giai đoạn build thì các giai đoạn build trước đó cũng sẽ được thực hiênj theo trình tự
  	VD: khi chạy test thì sẽ chạy compile, validate, khi chạy verify sẽ chạy cả package, ... validate

#### Clean lifecycle

- `Pre-clean`: thực hiện yêu cầu trước khi làm sạch dự án.
- `Clean`: xóa tất cả các file liên quan tới các lần build trước đó.
- `Post-clean`: thực hiện yêu cầu khi hoàn thành việc làm sạch dự án.

#### Site lifecycle

- Site lifecycle sẽ thực hiện việc tạo và triển khai theo document site của project.

## Gradle

- trong gradle thì có thể viết các `task, plugin, config script` như viết code bình thường(groovy)
- build sẽ chạy 1 `task` cụ thể nào đó, và `task` này sẽ chạy 1 `plugin` nào đó để chạy các `task` phải thực hiện trong
  việc `build` hoặc đóng gói
- khi `build` sẽ có 1 đối tượng là `project` dùng để config các thuộc tính khi chạy
