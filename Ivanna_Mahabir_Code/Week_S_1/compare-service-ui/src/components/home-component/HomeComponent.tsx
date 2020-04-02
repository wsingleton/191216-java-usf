import React from 'react';

export class HomeComponent extends React.Component<any, any>{
    constructor(props: any){
        super(props)
        this.state = {
            imgsrc:""
        }
    }

    componentDidMount(){
        this.setState({
            ...this.state,
            imgsrc: "https://s3.console.aws.amazon.com/s3/buckets/elasticbeanstalk-us-east-2-950115502660/?region=us-east-2"
        });
    }
    render(){
        return(
            <div className="content">
                <img src={this.state.imgsrc} className="imgdisp" alt=""/>
                <button className="first">Select</button>
            </div>
        )
    }
}