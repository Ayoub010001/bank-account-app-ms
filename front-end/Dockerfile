#stage 1
FROM node:latest as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app/
RUN npm install
RUN npm run build

#Stage2
FROM nginx:latest
COPY --from=build /usr/local/app/dist/front-end/browser /usr/share/nginx/html
#port 80 Exposed
EXPOSE 80