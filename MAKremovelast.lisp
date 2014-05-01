(define remove-last 
 (lambda (item lst) 
 (cond 
 ((null? lst) '()) 
 ((and (equal? item (car lst)) (not (member? item (cdr lst)))) (cdr lst)) 
 (else (cons (car lst) (remove-last item (cdr lst))))) 
)) 
 
(remove-last 'a '(b a n a n a s))    ; (b a n a n s) 
(remove-last '(a b) '(a b (a b) a b (b a) a b (a b) a b))    ; (a b (a b) a b (b a) a b a b) 