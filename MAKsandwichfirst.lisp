(define sandwich-first
 (lambda (a b lst)
 (cond
 ((null? lst) '())
 ((null? (cdr lst)) lst)
 ((and (equal? b (car lst)) (equal? b (cadr lst)))
 (append (list b a b) (cddr lst)))
 (else (cons (car lst) (sandwich-first a b (cdr lst)))))
))

(sandwich-first 'meat 'bread '(bread bread)) ; (bread meat bread) 
(sandwich-first 'meat 'bread '()) ; () 
(sandwich-first 'meat 'bread '(meat meat)) ; (meat meat)