public class NODE {
	protected String name;  // å�̸� 
	protected String writer;  // ����
	protected String publisher;  // ���ǻ�
	protected String nation;  // ����
	protected String year;  // ����⵵
	protected String price;  // ����
	protected String barcode; //���ڵ�
	public NODE left, right;
	
	public NODE(String[] t) {
		name = t[0];
		writer = t[1];
		publisher = t[2];
		nation = t[3];
		year = t[4];
		price = t[5];
		barcode = t[6];
		left = null;
		right = null;
	}


 public void inOrder() {
  if (left != null){
   left.inOrder();
  }
  System.out.println(name+"   "+writer+"   "+publisher+"   "+nation+"   "+year+"   "+price+"   "+barcode);
  if (right != null) {
   right.inOrder();
  }
 }
 
 public void preOrder() {
  System.out.println(name);
  if (left != null) {
   left.preOrder();
  }
  if (right != null) {
   right.preOrder();
  }
 }
 public void postOrder() {

  if (left != null) {
   left.postOrder();
  }

  if (right != null) {
   right.postOrder();
  }
  System.out.println(name);
 }

 public NODE getLeft() {
  return left;
 }

 public void setLeft(NODE left) {
  this.left = left;
 }

 public NODE getRight() {
  return right;
 }

 public void setRight(NODE right) {
  this.right = right;
 }

 public String[] getData() {
	 String[] k = {name,writer,publisher,nation,year,price,barcode};
	 return k;
 }
 public void setData(String[] k) {
		name = k[0];
		writer = k[1];
		publisher = k[2];
		nation = k[3];
		year = k[4];
		price = k[5];
		barcode = k[6];
 }

}