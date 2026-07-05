from flask import Flask, render_template

app = Flask(__name__)

@app.route('/cart')
def cart():
    return 'This is the page where items added to the cart are displayed.'

@app.route('/checkout')
def checkout():
    return 'This the page where the checkout of the product will be taken up'

@app.route('/mainpage')
def mainpage():
    return render_template('index.html')
@app.route('/Contact')
def contact():
    return 'You can Contact to Gowtham Who is the Owner of this page! 😎'

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080, debug=True)
