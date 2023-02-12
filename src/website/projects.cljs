(ns website.projects
  (:require
   [reagent-mui.material.typography :refer [typography]]
   [reagent-mui.material.button :refer [button]]
   [reagent-mui.material.card :refer [card]]
   [reagent-mui.material.card-content :refer [card-content]]
   [reagent-mui.material.card-actions :refer [card-actions]]
   [reagent-mui.material.card-action-area :refer [card-action-area]]
   [reagent-mui.material.paper :refer [paper]]
   [reagent-mui.material.card-media :refer [card-media]]
   [reagent-mui.material.container :refer [container]]
   [reagent-mui.material.grid :refer [grid]]
   ))

(def projects-info
  {:website {:title "Portfolio Website"
             :last-updated "Early 2023"
             :short-desc "The website you are on right now!"
             :image "images/website-image-1-small.png"
             :link "https://github.com/sgshea/website"}
   :tictactoe {:title "Tic-Tac-Toe"
               :last-updated "Summer 2022"
               :short-desc "Tic-Tac-Toe implementation in Clojure using Cljfx for GUI."
               :image "images/ttt-image-2-small.png"
               :link "https://github.com/sgshea/tic-tac-toe"}
               })

(defn project-item
  [project-info]
  (let [id (project-info 0)
        info (project-info 1)]
    [grid {:item true
          :xs 12
          :md 6}
    [card {:sx {:max-width 500}
           :variant "outlined"}
      [card-media {:sx {:height 300}
                   :image (info :image)
                   :title id}]
      [card-content
      [typography {:gutter-bottom true
                    :variant :h5
                    :component "div"}
      (info :title)]
      [typography {:variant "body2"
                    :color "text.secondary"}
        (info :short-desc)]
      [:br]
      [typography {:gutter-bottom true
                    :variant :body2
                    :color "text.secondary"}
      (str "Last updated: " (info :last-updated))]]
      [card-actions
      [button {:size "small"
               :href (info :link)}
        "GitHub"]]]]))

(defn projects
  "Grid of projects"
  []
  [container {}
    [paper {:eleveation 5
            :xs 7}
     [typography {:variant :h3
                  :color "text.primary"
                  :text-align "center"
                  :m 5}
      "Personal Projects"]]
    [grid {:container true
           :spacing 1
           :direction "row"
           }
      (map project-item projects-info)]])