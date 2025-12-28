import "./globals.css"
import "bootstrap/dist/css/bootstrap.min.css"

export default function IndexLayout({ children }) {
  return (
    <html lang="en">
      <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      </head>
      <body>
        <main className="container d-flex flex-column align-items-start justify-content-start">
          {children}
        </main>
      </body>
    </html>
  );
}
