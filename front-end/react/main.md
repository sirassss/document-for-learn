## Concept

- Mọi component trong react đều phải giống pure function(hàm sẽ luônt trả về 1 giá trị với cùng 1 tham số)
- Phương thức `componentDidMount()` chạy sau khi đầu ra component đã được render vào trong DOM
- nếu 1 component có hàm render trả về null thì component sẽ không render cái gì nhưng các phương thức lifecycle vẫn
  chạy bình thường
- thuộc tính `key` của React dùng để định danh phần từ trong 1 list giúp không phải rerender nhưng phần tử đã có
- ref là 1 đối tượng lấy event trong DOM element mà không cần phải xử lý event thông qua onChange, onClick, ...

### state

- state cũng giống như props nhưng nó là của riêng component,
- mỗi lần sử dụng `setState` thì render() của component đó sẽ được gọi lại
- nếu sửa đổi state trực tiếp thì render() sẽ không được gọi, chỉ nên sửa trực tiếp ở constructor
- `setState` có cách gọi thứ 2 là nhận 1 function nhận `preState` và `props` làm tham số
- sau khi chay setState thì render sẽ chạy cả parent lẫn child component
- stateful: là component có quản lý state và cập nhật state
- stateless: là component không quản lý state và chỉ thực hiện các công việc đơn giản

### props

- nếu truyền arrow function vào props của 1 child component thì child component sẽ bị render lại, gây ra vấn đề hiệu
  suất
- có thể truyền prop là 1 component 

### hook

- có thể sử dụng nhiều hơn 1 hook trong 1 functional component

- useState sẽ thay thế state chứ không gộp lại state như setState của class
- useEffect cleanup sẽ chạy cả khi re-render chứ không nhất thiết là unmounting mới chạy, có thể thêm 1 param để cho
  useEffect biết nếu param đó thay đổi thì mới chạy effect
- các hook chạy từ trên xuống dưới
- useContext: 1 component sẽ luôn rerender khi giá trị của context thay đổi
  - defaultValue sẽ đựa sử dụng nếu như không có provider trong component tree

## binding

- component sẽ nhận value thông qua event và 


## js

- nếu trỏ tới phương thức mà không có () theo sau như onClick={this.handleClick}, nên ràng buộc phương thức đó (bind).
- this trong base function sẽ ràng buộc với instance của class đó, nó sẽ trỏ tới instance của class mà phương thức đang
  được gọi
- this trong arrow function sẽ được tự động thừa kế giá trị từ this từ phạm vi bên ngoài(lexical this binding) nơi
  fuction được khai báo

> có thể coi arrow function là 1 thuộc tính đối tượng và có tham chiếu còn base function như method của java, tham chiếu
> của this trong arrow function đã trỏ ở đối tượng cũ khi được khởi tạo còn method thì chỉ đơn giản là 1 cái khung nên
> this của base function sẽ gắn với instance của nó

- tham số event của React hay Html đối với base function thì sẽ tự động truyền còn đối với arrow function thì phải
  truyền thủ công

### functional component

- còn được gọi là stateless functional component
- chuyên để viết các component đơn giản
- không thể access được các phương thức của component

### bind() của 1 function

- có thể gán param đầu là this và các param sau là tham số của function
  - VD:
  ````js
  function addNumbers(a, b) {
    return a + b;
  }

  const addFive = addNumbers.bind(null, 5);// gán a = 5
  console.log(addFive(3)); // Kết quảD là 8
  ````

### module.exports, export default

- trong node thì 1 module đại diện cho 1 function, class, object, và export nó ra để module khác có thể sử dụng lại,
  export default trong node cũng có ý nghĩa tương tự
- trong js thuần thì ta có thể sử dụng export default, import from trong es6 trở lên để thao tác các module và phải có
  thẻ script có type là module trong html



