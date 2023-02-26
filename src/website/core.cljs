(ns website.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [reagent-mui.colors :as colors]
     [reagent-mui.styles :as styles]
     [reagent-mui.material.css-baseline :refer [css-baseline]]
     [reagent-mui.material.grid :refer [grid]]
     [reagent-mui.material.snackbar :refer [snackbar]]
     [reagent-mui.material.alert :refer [alert]]
     [reagent-mui.material.typography :refer [typography]]
     [reagent-mui.material.box :refer [box]]
     [reagent-mui.material.container :refer [container]]
     [reagent-mui.material.app-bar :refer [app-bar]]
     [reagent-mui.material.toolbar :refer [toolbar]]
     [reagent-mui.material.button :refer [button]]
     [reagent-mui.icons.brightness-4 :refer [brightness-4]]
     [reagent-mui.icons.brightness-7 :refer [brightness-7]]
     [reagent-mui.material.menu :refer [menu] :as menu-component]
     [reagent-mui.material.menu-item :refer [menu-item]]
     [reagent-mui.icons.menu :refer [menu] :rename {menu menu-icon}]
     [reagent-mui.material.icon-button :refer [icon-button]]
     [clojure.string :as str]
     [website.about :as about]
     [website.projects :as projects]))

;; -------------------------
;; Views
(defn under-construction
  "Alert to indicate website is currently being updated"
  [status? date]
  (if status?
    [snackbar {:open true}
    [alert {:severity "warning"}
      (str "As of " date " I am currently doing a major overhaul/update of the website!")]]
    nil))

;; Theme
(defonce theme-mode
  (r/atom :light)) 

(defn toggle-dark-mode
  "Toggles between light and dark mode"
  []
  (if (= @theme-mode :light)
    (reset! theme-mode :dark)
    (reset! theme-mode :light)))

(defn custom-theme [mode] {:palette {:mode mode
                             :primary colors/blue 
                             :secondary colors/red}})
;; -------------------------
;; App Bar
(defn event-value
  [e]
  (.. e -target -value))

;; Below is the code for the app-bar
(def pages
  ["About" "Projects" "Skills"])

(defonce anchorElNav (r/atom nil))

(defn pages-item
  [page-name]
  [:a {:href (str "#" (str/lower-case page-name))}
  [menu-item {:key page-name
              :on-click (fn [e]
                         (reset! anchorElNav (event-value e)))}
      [typography {:textAlign "center"
                   :color "text.primary"}
        page-name]]])

(defn pages-button
  [page-name]
  [button {:key page-name
           :on-click (fn [e]
                      (reset! anchorElNav (event-value e)))
           :sx {:my 2
                :color "text.secondary"
                :display "block"}
           :href (str "#" (str/lower-case page-name))}
   page-name]) 

(defn menu-bar
  "Top bar for the pages"
  []
  [app-bar {:enableColorOnDark true
            :color "transparent"}
   [container {:maxWidth "x1"}
     [toolbar {:disableGutters true}
      [typography {:variant :h5
                   :noWrap true
                   :component :a
                   :href "/"
                   :sx {:mr 2
                        :display {:xs "none"
                                  :md "flex"}
                        :fontFamily "monospace"
                        :fontWeight 700
                        :textDecoration "none"
                        :color "text.primary"}}
       "Sammy Shea"]
      [box {:sx {:flexGrow 1
                 :display {:md "none"}}}
       [icon-button {:size "large"
                     :aria-label ""
                     :aria-controls "menu-appbar"
                     :aria-haspopup true
                     :on-click (fn []
                                (reset! anchorElNav true))
                     :color "inherit"
                     :style {:margin-left "-12px"
                             :margin-right "20px"}}
        [menu-icon]]
       [menu {:id "menu-appbar"
              :anchor-el anchorElNav
              :anchorOrigin {:vertical "top"
                             :horizontal "left"}
              :keepMounted true
              :transformOrigin {:vertical "top"
                                :horizontal "left"}
              :open (some? @anchorElNav)
              :onClose (fn []
                         (reset! anchorElNav nil))
              :sx {:display {:xs "block"
                             :md "none"}}} 
        (map pages-item pages)]]
      [typography {:variant :h5
                   :noWrap true
                   :component :a
                   :href "/"
                   :sx {:mr 2
                        :display {:xs "flex"
                                  :md "none"}
                        :fontFamily "monospace"
                        :fontWeight 700
                        :textDecoration "none"
                        :color "text.primary"}}
       "Sammy Shea"]
      [box {:sx {:flexGrow 1
                 :display {:xs "none"
                           :md "flex"}}}
       (map pages-button pages)]
      [icon-button {:sx {:m 1}
                    :color "inherit"
                    :on-click #(toggle-dark-mode)
                    }
       (if (= @theme-mode :light)
         [brightness-4]
         [brightness-7])]
      ]]])

;; -------------------------
;; Initialize website
(defn home-page []
  [:box {}
    [:<>
    [styles/theme-provider (styles/create-theme (custom-theme @theme-mode))
     [css-baseline
     [grid {:container true
            :justify-content "center"}
      [under-construction false "Feburary 2023"]
      [about/about]
      [projects/projects]
      [about/technologies]]
     [menu-bar]
     ]]]])


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
