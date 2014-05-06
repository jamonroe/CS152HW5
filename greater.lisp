(define a '(3 2 1))

(> 2 1)
;t

(> 3 2 1)
;t

(> 1 2)
;f

(> (car a) 2)
;t

(> (cdar a) 2)
;f

(> (car a) (cdar a))
;t