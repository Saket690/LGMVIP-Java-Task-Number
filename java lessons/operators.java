public class operators {
    
    public static void main(String agrs[]){

        int arr[] = {1, 2, 3,4,4};
        //bubble sort
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[i] >arr[i+1]){
                    int temp = arr[i];
                    arr[i]= arr[i+1];
                    arr[i+1] = temp;



                }
            }
        }

        
    }
    
}
  