#!/bin/bash
NOW=$(date +%d.%m.%y)
wkhtmltopdf -L 15 -R 10 -T 15 -B 15 --header-line --header-spacing 5 --header-font-size 8 --header-left "Gleb Uvarov" --header-right "$NOW" --footer-line --footer-spacing 5 --footer-font-size 8 --footer-right [page] plain.html G.Uvarov_CV.pdf