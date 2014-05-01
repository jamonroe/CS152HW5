(define member? 
 (lambda (item lst) 
 	(cond 
 		((null? lst) #f) 
 		((equal? item (car lst)) #t) 
 		(else (member? item (cdr lst))) 
))) 
 
(member? 3 '(1 2 3)) ; #t 
(member? 'b '(a (b c) d)) ; #f 