(ns website.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [website.content :as content]))

;; -------------------------
;; State
(def !theme
  (r/atom "dark"))

(defn switch-theme
  []
  [:a {:class "button is-rounded is-outlined is-dark is-inverted"
       :on-click #(swap! !theme (fn []
                                  (if (= @!theme "dark")
                                    "light"
                                    "dark")))} @!theme
   [:span {:class "icon"}
    [:i {:class "fas fa-cloud-sun"}]]])

;; Main Page
(defn main-page []
  [:div.dark-theme {:class "container"}
   [content/top-nav switch-theme]
   [content/separator "overview"]
   [content/overview]
   [content/separator "website-project"]
   [content/website-project]
   [content/separator "tic-tac-toe-project"]
   [content/tic-tac-toe-project]
   [content/separator "class-216"]
   [content/class-216]
   ])

;; System
(defn mount-root []
  (d/render [main-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))