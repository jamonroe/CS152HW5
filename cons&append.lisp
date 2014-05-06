(cons 1 '())
; (1)

(cons 1 (cons 2 (cons 3 '())))
; (1 2 3)

(append '(1 2) '(3 4))
; (1 2 3 4)

(append '((1 2) (3 4)) '((5 6) (7 8)))
       ; ((1 2) (3 4) (5 6) (7 8))