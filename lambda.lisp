(define a (lambda (b) (+ 1 b)))
;null
(define d (lambda (a f) (+ a f)))
;null

(a 1)
;2
(d 3 4)
;7
(a 2)
;3