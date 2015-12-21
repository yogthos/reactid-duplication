(ns reactid-duplication.core
    (:require [reagent.core :as reagent :refer [atom]]))

(def modal? (atom false))

(defn modal []
  (fn []
    [:div
     [:div.modal-dialog
      [:div.modal-content
       [:div.modal-header [:h3 "Modal Header"]]
       [:div.modal-body "I'm a modal"]
       [:div.modal-footer
        [:div.bootstrap-dialog-footer
         [:button.btn.btn-danger
          {:on-click #(reset! modal? false)} "Ok"]]]]]]))

(defn home-page []
  [:div
   [:div.container>div.row>div.col-md-12
    [:h2 "modal-test"]
    [:li.dropdown.open
       [:a.dropdown-toggle
        [:ul.dropdown-menu
         [:li>a {:on-click #(reset! modal? true)}
          "action 1"]
         [:li>a {:on-click #(println "action 2")}
          "action 2"]]]]
    (when @modal?
      [modal])]])

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
