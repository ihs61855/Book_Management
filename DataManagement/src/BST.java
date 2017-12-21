import java.io.FileWriter;
import java.io.IOException;

public class BST{
 public NODE root;
 public String pass;

 public BST() {
  root = null;
  pass = null;
 }

 public boolean isEmpty() {
  return root == null;
 }

 public void clear(){
  root = null;
 }


 public void inOrder() {
  root.inOrder();
 }

 public void preOrder() {
  root.preOrder();
 }

 public void postOrder() {
  root.postOrder();
 }


 public boolean insert(String[] t) {
  NODE newNode = new NODE(t);
  NODE pointer;
  boolean insertComplete = false;
  if (isEmpty()) {
   root = newNode;
   return true;
  } else {
   pointer = root;
   
   
   while (!insertComplete) {
    if (pointer.name.compareTo(t[0])>0) 
    {
     if (pointer.getLeft() != null) {
      pointer = pointer.getLeft();
    }
     else
     {
      pointer.setLeft(newNode);
      insertComplete = true;
      break;
     }
    } else if (pointer.name.compareTo(t[0])<0) {
     if (pointer.getRight() != null) {
      pointer = pointer.getRight();
     } else {
      pointer.setRight(newNode);
      insertComplete = true;
      break;
     }
    } else {

     break;
    }
   }
   
  }

  return insertComplete;
 }


 public boolean remove(String name_){
     NODE parent = root;
     NODE current = root;
     boolean isLeftChild = false;
     while((!current.name.equals(name_))){
         parent = current;
         int i=current.name.compareTo(name_);
         if(i>0){
             isLeftChild = true;
             current = current.getLeft();
         }else{
             isLeftChild = false;
             current = current.getRight();
         }
         if(current==null){
             return false;
         }
     }
     //Case 1: 자식노드가 없는 경우
     if(current.getLeft()==null && current.getRight()==null){
         if(current==root){
             root = null;
         }
         if(isLeftChild==true){
             parent.setLeft(null);
         }else{
             parent.setRight(null);
         }
     }
   //Case 2 : 하나의 자식을 갖는 경우
     else if(current.getRight()==null){
         if(current==root){
             root = current.getLeft();
         }else if(isLeftChild){
             parent.setLeft(current.getLeft());
         }else{
             parent.setRight(current.getLeft());
         }
     } else if(current.getLeft()==null){
         if(current==root){
             root = current.getRight();
         }else if(isLeftChild){
             parent.setLeft(current.getRight());
         }else{
             parent.setRight(current.getRight());
         }
     }
     //Case 3 : 두개의 자식을 갖는 경우
     else if(current.getLeft()!=null && current.getRight()!=null){
         // 오른쪽 서브트리의 최소값을 찾음
         NODE successor = getSuccessor(current);
         if(current==root){
             root = successor;
         }else if(isLeftChild){
             parent.setLeft(successor);
         }else{
             parent.setRight(successor);
         }            
         successor.setLeft(current.getLeft());
     }

     return true;        
     
 }
 
 
 public NODE getSuccessor(NODE deleleNode){
     NODE successsor =null;
     NODE successsorParent =null;
     NODE current = deleleNode.getRight();
     while(current!=null){
         successsorParent = successsor;
         successsor = current;
         current = current.getLeft();
     }
     if(successsor!=deleleNode.getRight()){
         successsorParent.setLeft(successsor.getRight());
         successsor.setRight(deleleNode.getRight());
     }
     return successsor;
 }
 
 public void save(NODE p, FileWriter w)
 {
    if(p != null)
    {
       save(p.getLeft(),w);
       try{
          String line=new String();
          line+=p.name;
          line+="&";
          line+=p.writer;
          line+="&";
          line+=p.publisher;
          line+="&";
          line+=p.nation;
          line+="&";
          line+=p.year;
          line+="&";
          line+=p.price;
          line+="&";
          line+=p.barcode;
          line+="\n";
          w.write(line);
          
       }
       catch(IOException e){
       }
       save(p.getRight(),w);
    }
 }
}
