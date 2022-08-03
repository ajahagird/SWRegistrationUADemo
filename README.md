This example intends to demo User-Agent header behavior during Service Worker registration. Demo has two components
1. https://incandescent-efficacious-woodwind.glitch.me installs Service Worker on the load.
2. Android App that, uses custom user agent, and loads this URL in a WebView.

```
final WebSettings settings = webView.getSettings();
final String defaultUA = settings.getUserAgentString();
settings.setUserAgentString(defaultUA + " MyApp/1.0.0");
```

### Steps
1. Open App. It will load the URL & install the service worker present at `https://incandescent-efficacious-woodwind.glitch.me/service-worker.js`
2. If you have access to server, observe incoming request user-agent for both main document `/` and `/service-worker.js`.
3. Alternative, connect device to Chrome DevTools. Ensure `Update on Reload` option is selected for Service Worker. Reload the page and observe the value of `x-incoming-user-agent` header for both main document and service-worker.js response in the network tab. This value is set by the server to echo the UA of request as seen by the server.

### Analysis
We observe that `MyApp/1.0.0` value is only observed for main document request, but not for service-worker.js request.