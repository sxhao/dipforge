package applications

import groovy.json.*

def builder = new JsonBuilder()

def menu = [
             [
                image: 'favicon.ico',
                title: '<b>News BBC</b>',
                url: 'http://news.bbc.co.uk/'
            ],
             [
                image: 'favicon.ico',
                title: 'CNN',
                url: 'http://www.cnn.com'
            ],
            [
                image: 'favicon.ico',                
                title: 'SKY',
                url: 'http://www.sky.com'
            ],
            [
                image: 'favicon.ico',                
                title: 'News 24',
                url: 'http://www.news24.com'
            ],
            [
                image: 'favicon.ico',                
                title: 'Space.com',
                url: 'http://www.space.com'
            ]]

builder(menu)

println builder.toString()