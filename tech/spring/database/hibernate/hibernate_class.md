## Remove entity

````java

@Entity
@NoArgsConstructor
@Setter
@Getter
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private ShipmentInfo shipmentInfo;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "orderRequest")
    private List<LineItem> lineItems;

    public void removeLineItem(LineItem lineItem) {
        lineItems.remove(lineItem);
    }
}
````

- có 2 cách gồm:
    - CascadeType.REMOVE: Khi xóa 1 entity OrderRequest thì ShipmentInfo liên kết tới nó cũng tự động bị xóa khỏi
      database
    - thuộc tính orphanRemoval: Khi chúng ta dùng OrderRequest#removeLineItem để ngắt liên kết giữa OrderRequest và một
      danh sách LineItem thì chúng cũng sẽ tự động bị xóa khỏi database

## @Inheritance trong hibernate

- @Inheritance(strategy = InheritanceType.JOINED) được định nghĩa trong 1 entity cha và các entity con sẽ kế thừa lại
  thuộc tính của entity cha và tạo ra bảng mới so với bảng cha và 2 bảng cha con liên kết với nhau qua khóa ngoại

## @Embeddable trong hibernate

- dùng để đánh dấu 1 bảng nhúng vào 1 entity khác
- `@Embedded`: được gắn vào 1 class và các thuộc tính của class đó sẽ được nhúng vào 1 entity như là thuộc tính của
  entity giống như
  việc gom thuộc tính vào 1 class mà không cần tạo bảng riêng cho những thuộc tính đó
- `@EmbeddedId`: gộp các thuộc tính vào 1 class để class đó làm id cho 1 entity ngoài ra còn có `@IdClass`

## @Size, @Length và @Column(length=value)

- @Size do JPA định nghĩa
- @Length do Hibernate định nghĩa, chức năng giống với @Size để có tác dụng là quy định min, max của thuộc tính
- @Column(length=value) dùng để chỉ định ký tự tối đa của cột trong db, nếu quá số lượng sẽ throw ra 1 sql error

## CASCADE

- là cơ chế cho phép lan truyền quá trình chuyển đổi từ một entity đến các related entity

#### JPA

- `PERSIST`: nếu lưu 1 entity thì các entity related cũng persist theo cũng như lưu theo
- `MERGE`: nếu như entity ở trạng thái detached thì sau khi merge thì nó cũng merge cả entity related cùng
- `REMOVE`: nếu như xóa entity thì entity related cũng xóa theo
- `DETACHED`: nếu như detached 1 entity thì entity related cũng detached theo
- `REFRESH`: refresh lại giá trị mới nhất của entity ở trong db cũng như entity related
- `ALL`: sử dụng hết các cascade trên

#### Hibernate

- `REPLICATE`: đồng bộ các entity giữa các datasource trong trường hợp có nhiều datasource trong app
- `SAVE_UPDATE`: giống PERSIST + MERGE của JPA
- `LOCK`: tác dụng giống SAVE_UPDATE nhưng không tạo câu insert chỉ đơn thuần đưa detached về persist

## Fetch

#### FetchMode

- sử dụng với @Fetch()
- `FetchMode.SELECT`: bảo hibernate tải related entity theo hướng lazy, có thể gây N+1 Problem
- @BatchSize sử dụng để gom các câu select cho `FetchMode.SELECT`
- `FetchMode.JOIN`: bảo hibernate tải related entity theo hướng eager
- `FetchMode.SUBSELECT`: để ở chiều many và bảo hibernate load chỉ 2 câu select để lấy cả 2 list entity

#### sự khác nhau giữa fetchType và fetchMode

- `fetchMode` chỉ định hibernate lấy dữ liệu như thế nào còn `fetchType` sẽ định nghĩa dữ liệu tải lên theo hướng lazy
  hay eager

- Nếu không chỉ định FetchMode trong entity FetchMode.JOIN sẽ được sử dụng mặc định và FetchType lúc này sẽ hoạt động
  như đúng những gì chúng được định nghĩa.
- Với FetchMode.SELECT hoặc FetchMode.SUBSELECT được đặt, FetchType vẫn sẽ hoạt động bình thường.
- Với FetchMode.JOIN được chỉ định, FetchType sẽ bị bỏ qua và các câu truy vấn sẽ luôn Eager.

> Như vậy giữa FetchType và FetchMode có mối tương quan lẫn nhau, khi FetchMode.JOIN được chỉ định, FetchType sẽ bị bỏ
> qua và truy vấn lấy dữ liệu luôn là Eager, đây là một điểm quan trọng hết sức cần lưu ý.
> Khi không chỉ định FetchMode thì mặc định nnó vẫn là JOIN thế nhưng nó cho phép FetchType hoặc định bình thường, trong
> trường hợp FetchType.Lazy thì xem như FetchMode.JOIN bị loại bỏ.

## @Enumerated

- chỉ định thuộc tính là 1 enum trong database và có thể lựa chọn là STRING hoặc ORDINAL

## GenerationType của id

- `AUTO`: mặc định cho phép persistence provider tự lựa chọn kiểu mà nó muốn, nó sẽ chọn kiểu generate key dựa trên
  database specific dialect.
- `IDENTITY`: nó luôn yêu cầu primary key của mỗi entity phải có giá trị để quản lý, nhưng để lấy được giá trị tiếp theo
  của Identity column chỉ có cách thực thi câu SQL Insert thì mới có thể biết được. Điều này dẫn đến các câu lệnh SQL
  Insert được thực thi ngay lập tức để lấy giá trị của Identity column, bị vô hiệu hoá tính năng Batch Insert JDBC.
  nó sẽ được thực thi ngay thời điểm persisted nếu là transient entity chứ không chờ đến flush-time
- `SEQUENCE`: Hibernate có thể sử dụng insert batch và được hibernate khuyên sử dụng