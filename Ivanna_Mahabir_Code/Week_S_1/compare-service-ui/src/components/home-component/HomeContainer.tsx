import {connect} from "react-redux";
import {IState} from "../../reducers";
import {HomeComponent} from "./HomeComponent";


const mapStateToProps = (state:IState) => {
    return{
        id:state.imageState.id
    }
}

const mapDispatchToProps = {

}

export default connect(mapStateToProps, mapDispatchToProps)(HomeComponent)