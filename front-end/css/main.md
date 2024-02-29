### key:

- `box-sizing: border-box`: làm cho tổng (width và padding và border) của content sẽ không đổi
- `inherit`: sẽ kế thừa thuộc tính của thể bọc nó(value của padding hoặc margin, ...)

- `background-repeat`: lặp lại hình ảnh theo chiều ngang hoặc dọc
- `background-attachment`: xác định ảnh background có scroll được hay không

- `outline-offset`: thuộc tính tạo khoảng cách giữa border và outline

- `text-align: justify`: căn đều 2 bên trái phải và trên dưới của text
- `text-align-last`: chỉnh dòng cuối cùng của văn bản
- `text-indent`: tạo 1 khoảng cách đằng trước của dòng đầu tiên của văn bản(thụt đầu dòng)
- `line-height`: khoảng cách giữa các dòng của 1 đoạn văn bản
- `white-space`: thuộc tính có thể bỏ dấu xuống dòng, giữ nguyên văn bản gốc, ... Tác động lên dấu xuống dòng của văn
  bản
- `overflow: auto`: chỉnh nội dung bên trong container cho phép scroll ngang hoặc dọc nếu width hoặc height không đủ
- `overflow: hidden`: ẩn nội dụng nếu nó bị tràn ra ngoài
- `display: block`: mặc định chiếm full độ rộng `có sẵn` ở 1 dòng mới ví dụ như div, p, form, ...
- `display: inline`: mặc định chiếm 1 độ rộng vừa đủ và `không` bắt đầu ở 1 dòng mới ví dụ như a, span, img,...
- `display: inline-block`: cho phép thay đổi padding, margin, width, height mà vẫn giữ đặc tính không xuống dòng của inline
- `display: grid`: căn chỉnh các elements theo dạng lưới(ngăn cách nhau bởi các khoảng trống)
- `display: flex`: dàn trải liền kề các element con theo hàng
- `display: contents`: flatmap với element cha, kế thừa toàn bộ thuộc tính
- `display: none`: xóa element khỏi DOM
- `visibility: hidden`: ẩn element khỏi DOM nhưng vẫn chiếm độ rộng

- `max-width`: có thể sử dụng max width thay cho width có độ dài cố định để browser tự handle width với thiết bị có kích
  thước nhỏ(`với điều kiện là phần tử cha width phải được chỉ định`)

- `position: static`: giá trị mặc định của các elements, các thuộc tính top, left, right, bottom đều không thể set khi
  có `position: static`
- `position: relative`: có thể set giá trị các thuộc tính cho top, left, right, bottom và có thể bị tràn ra ngoài phần
  tử cha nhưng `khoảng trống nó để lại sẽ không được fill` theo mặc định(giống như việc ẩn khỏi DOM nhưng vẫn chiếm độ
  rộng)
- `position: fixed`: có thể set value cho top, left, right, bottom và luôn cố định tại 1 khung hình và không để lại
  khoảng trống trong element cha(giống như xóa luôn khỏi element cha)
- `position: absolute`: có thể set top, left, right, bottom và cố đinh theo element cha với điều kiện element cha KHÔNG
  được set `position: static` (cha di chuyển đâu con di chuyển theo đó) và không chiếm độ rộng của DOM
- `position: sticky`: giống như `fixed` nhưng không cố định theo màn hình mà `scroll gặp cuối màn hình` mới cố định với
  điều kiện phải có set phần tử đi kèm top, left, right, bottom, scroll xuống thì set top, scroll lên thì set bottom,...

- `float`: đưa element ra bên chỉ định và ở trên các phần tử khác
- `clear`: có tác dụng khi có `float`, nếu float: right thì element clear:right sẽ ở ngay bên dưới phần tử float chứ
  không ở bên cạnh


- `transition`: tạo hiệu ứng chuyển đổi cho các thuộc tính khác: transform, color, opacity, ... có thể dùng hàm
  cubic-bezier(x1,x2,y1,y2) trong đó x1 là v đầu, y1 là gia tốc đầu,..
- `animation: myAnimation 3s infinite`: myAnimation là animation tự định nghĩa, infinite là số lần lặp vô hạn
- `@keyframes`: xác định animation cho các giai đoạn(xác định bằng phần trăm)

- `::before, ::after`: là 2 hậu tố của selector có tác dụng thêm element ảo mà không cần thêm thẻ html
- `Combinators`:
  - <space>: element cha đến tất cả elements con
  - `>`: element cha đến elements con 1 cấp

- `resize: none`: không cho phép thay đổi size của phần tử bằng cách kéo thả(vd: textarea)



