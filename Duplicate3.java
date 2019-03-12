class Duplicate3{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if(length < 1)
        {
            return false;
        }
        else
        {
            for(int i = 0; i < length; i++)
            {
                for(int j = i+1; Math.abs(j-i) <= k && j < length; j++)
                {
                    long diff =((long) nums[i]-(long) nums[j]);
                    if( Math.abs(diff) <=t )
                    {
                        return true;
                    }
                }
            }
            
        }
        return false; 
    }
}