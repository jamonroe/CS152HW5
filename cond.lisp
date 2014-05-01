(cond 
 		((eq? 1 0) 'no)
 		((eq? 3 2) 'no)
 		((eq? 4 5) 'no)
 		(ELSE 'yes) 
)

(cond
	((eq? 1 1) 'yes)
)

(cond 
 		((eq? 1 1) 'yes)
 		((eq? 3 2) 'no)
 		(ELSE 'no) 
)