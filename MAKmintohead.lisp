(define min-to-head 
 (lambda (lst) 
 (cond 
 ((null? lst) '()) 
 ((null? (cdr lst)) lst) 
 (else (let* ((new-lst (min-to-head (cdr lst))) 
 (second (car new-lst))) 
 (if (> (car lst) second) 
 (cons second (cons (car lst) (cdr new-lst))) 
 lst))) 
))) 
 
(min-to-head '(5 8 1 0 6 2 1 9)) ; (0 5 8 1 6 2 1 9) 

(define sort 
 (lambda (lst) 
 (if (null? lst) 
 '() 
 (let ((mth (min-to-head lst))) 
 (cons (car mth) (sort (cdr mth))))) 
)) 
 
(sort '(5 8 1 0 6 2 1 9)) ; (0 1 1 2 5 6 8 9)