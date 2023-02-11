(ns website.projects
  (:require
   [reagent-mui.material.typography :refer [typography]]
   [reagent-mui.material.box :refer [box]]
   [reagent-mui.material.stack :refer [stack]]
   [reagent-mui.material.paper :refer [paper]]
   [reagent-mui.material.card :refer [card]]
   [reagent-mui.material.card-content :refer [card-content]]
   [reagent-mui.material.card-actions :refer [card-actions]]
   [reagent-mui.material.card-action-area :refer [card-action-area]]
   [reagent-mui.material.card-media :refer [card-media]]
   [reagent-mui.material.card-header :refer [card-header]]
   [reagent-mui.material.container :refer [container]]
   [reagent-mui.material.grid :refer [grid]]
   ))

(def project-information
  {:portfolio {:id "website"
               :title "Portfolio Website"
               :short-desc "This is the website you are on right now!"}
   :tic-tac-toe {:id "tictactoe"
                 :title "Tic-Tac-Toe"
                 :short-desc "A small tic-tac-toe implementation in Clojure."
                 :main-image "images/ttt-image-1.png"}})

(defn project-item 
  [project-info]
  [grid {:item true}
   [card {:sx {}}
    [card-action-area
     [card-media {:component "img"
                  :height "200"
                  :image (:main-image project-info)
                  :alt (str "Image of " (:title project-info))}]
     [card-content
      [typography {:gutterBottom true
                   :variant :h5
                   :component "div"}
       (:title project-info)]
      [typography {:variant "body2"
                   :color "text.secondary"}
       (:short-desc project-info)]]]]])

(defn projects
  "Grid of projects"
  []
  [container {}
    [typography {:variant :h4
                 :mt 5
                 :text-align "center"}
      "Projects"]
    [box {:sx {:bgcolor ""}
          :mt 5}
    [grid {:container true
            :spacing {:xs 2
                      :md 2}}
      (map project-item project-information)]]])