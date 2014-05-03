(and #t #t #t #t #t #t #t)
; #t

(and #t #t #t #t #t #t #t #f)
; #f

(and (eq? 1 1) (integer? 2))
; #t

(and (equal? 0 1) (boolean? 2))
; #f

(or #t #f)
; #t

(or #f #f #f #f #f #f #f #f #f #t)
; #t

(define A 1)
(define B 'C)

(and (symbol? B) (symbol? 'A))
; #t

(or (symbol? "String") (symbol? A))
; #f