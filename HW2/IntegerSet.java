public class IntegerSet {
    boolean[] set = {};


    public IntegerSet(){
        set = new boolean[101];
    }
  
    public IntegerSet union(IntegerSet iSet){
        IntegerSet u = new IntegerSet();
        for(int i = 0; i < set.length; i++){
            u.set[i] = iSet.set[i] || set[i];
        }

        return u;
    }
  
    public IntegerSet intersection(IntegerSet iSet){
        IntegerSet u = new IntegerSet();
        for(int i = 0; i < set.length; i++){
                u.set[i] = iSet.set[i] && set[i];
        }

        return u;
    }
  
    public IntegerSet insertElement(int data){
        for(int i = 0; i < set.length; i++){
            if(i == data){
                set[i] = true;
            }
        }

        return this;
    }

    public IntegerSet deleteElement(int data){
        for(int i = 0; i < set.length; i++){
            if(i == data){
                set[i] = false;
            }
        }

        return this;
    }
  
    public boolean isEqualTo(IntegerSet iSet){
        for(int i = 0; i < set.length; i++){
            if(set[i] != iSet.set[i]){
                return false;
            }
        }

        return true;
    }
  
    public String toString(){
        String setString = "";
        for(int i = 0; i < set.length; i++){
            if(set[i] == true){
                setString+=i + " ";
            }
        }
        if(setString.length() == 0){
            return "---";
        }
        return setString;
    }
}
