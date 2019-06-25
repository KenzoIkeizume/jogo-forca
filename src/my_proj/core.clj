(ns my-proj.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu []
  (println "Voce perdeu"))

(defn ganhou []
  (println "Voce ganhou"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (print "acertos: ")
  (println acertos)
  (empty? (letras-faltantes palavra acertos)))

(defn le-letra! []
  (println "Tente outra letra")
  (read-line))

(defn acertou? [chute palavra]
  (.contains palavra chute))

(defn avalia-chute [chute vidas palavra acertos]
  (if (acertou? chute palavra)
    (jogo vidas palavra (conj acertos chute))
    (jogo (dec vidas) palavra acertos)))

(defn jogo [vidas palavra acertos]
  (cond
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
    :else
    (let [chute (le-letra!)]
      (if (acertou? chute palavra)
        (do
          (println "Acertou a letra")
          (recur vidas palavra (conj acertos chute)))
        (do
          (println "Errou a letra")
          (recur (dec vidas) palavra acertos))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; comment test
