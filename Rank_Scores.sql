Select sc.Score,(Select Count(1) + 1 From (Select Distinct Score from Scores) as us where us.Score > sc.Score) as rank 
From Scores sc 
Order by sc.Score Desc;