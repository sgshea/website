(ns website.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [website.about :as wabout]
     ["react-particles$default" :as Particles]
     ["tsparticles-slim" :refer (loadSlim)]))

(defn init-particles [engine]
  (loadSlim engine))

(defn ts-particles []
  (let [options {:fullscreen {:enable true
                              :zIndex 0}
                 :interactivity {
                                 :events {:onClick {:enable true
                                                    :mode "push"}
                                          :onHover {:enable true
                                                    :mode "repulse"}}}
                 :particles
                 {:number {:value 100}
                  :links {:enable true
                          :distance 85
                          :triangles {:enable true
                                      :opacity 0.1}}
                  :move {:enable true
                         :speed 1}
                  :size {:value 1}
                  :shape {:type "circle"}}}]
    [(r/adapt-react-class Particles) {:options options :init init-particles}]))

;; -------------------------
;; Initialize website
(defn home-page []
  [:div
   [wabout/main]
   [ts-particles]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
