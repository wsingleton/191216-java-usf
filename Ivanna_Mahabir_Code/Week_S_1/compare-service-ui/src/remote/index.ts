import axios from 'axios';

export const apiClient = axios.create({
    baseURL: 'https://s3.console.aws.amazon.com/s3/buckets/elasticbeanstalk-us-east-2-950115502660/?region=us-east-2'
})